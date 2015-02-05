package com.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SimpleChannelInboundHandlerAdapter<T> extends ChannelHandlerAdapter{

    public void channelActive(ChannelHandlerContext ctx) {
        // TODO Auto-generated method stub
        
    }

    public void channelRead0(ChannelHandlerContext ctx,
                             ByteBuf in) {
        // TODO Auto-generated method stub
        
    }

    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        // TODO Auto-generated method stub
        
    }

}
