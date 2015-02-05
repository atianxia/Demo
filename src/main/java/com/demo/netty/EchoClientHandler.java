package com.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

@Sharable
// #1
public class EchoClientHandler extends SimpleChannelInboundHandlerAdapter<ByteBuf> {
    @Override
public void channelActive(ChannelHandlerContext ctx) {
        ctx.write(Unpooled.copiedBuffer("Netty rocks!",CharsetUtil.UTF_8 ));//#2
}

    @Override
public void channelRead0(ChannelHandlerContext ctx,
ByteBuf in) {
System.out.println("Client received: "+ ByteBufUtil.hexDump(in.readBytes(in.readableBytes()))); //#4
}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, // #5
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}