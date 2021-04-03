package net.runeduniverse.hexagon.network;

import java.net.InetSocketAddress;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ByteProcessor;

public class InboundHandler extends ChannelInboundHandlerAdapter {
	
	@Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().toString()+" joined the server!");
    }
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf buffer = (ByteBuf) msg;
		System.out.println("\nIncoming:");
		buffer.forEachByte(new ByteProcessor() {

			@Override
			public boolean process(byte value) throws Exception {
				System.out.print("0x"+String.format("%02X ", value));
				return false;
			}
		});
		buffer.release();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
