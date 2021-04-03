package net.runeduniverse.hexagon.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyController {
	
	private final int port;
	private final EventLoopGroup bossGroup = new NioEventLoopGroup();
	private final EventLoopGroup workerGroup = new NioEventLoopGroup();
	private final ServerBootstrap bootstrap = new ServerBootstrap();
	private ChannelFuture serverChannel;
	
	public NettyController(int port) {
		this.port = port;
	}
	
	public NettyController init() {
		bootstrap.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new InboundHandler());
            }
        })
        .option(ChannelOption.SO_BACKLOG, 128)
        .childOption(ChannelOption.SO_KEEPALIVE, true);
		return this;
	}

	public void start() {
        try {
        	this.serverChannel = this.bootstrap.bind(this.port).sync();
        }
        catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void stop() {
        try {
			this.serverChannel.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
	}

}
