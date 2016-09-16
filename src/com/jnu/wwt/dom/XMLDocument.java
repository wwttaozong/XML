package com.jnu.wwt.dom;

import com.jnu.wwt.node.Node;

/**
 * Created by wwt on 2016/9/16.
 */
public class XMLDocument {

    /**
     * XML版本，默认1.0
     */
    private String version="1.0";

    /**
     * XML文档编码格式，默认utf-8
     */
    private String encoder="utf-8";

    /**
     * XML文档根节点
     */
    private Node root;

    /**
     * 打印XML文档
     */
    public void print(){
        StringBuilder sb=new StringBuilder();
        sb.append("<?xml version=\""+version+"\""+" encoding=\""+encoder+"\""+"?>");
        System.out.println(sb.toString());
        if(root != null){
            root.print();
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEncoder() {
        return encoder;
    }

    public void setEncoder(String encoder) {
        this.encoder = encoder;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "XMLDocument{" +
                "encoder='" + encoder + '\'' +
                ", root=" + root +
                '}';
    }
}
