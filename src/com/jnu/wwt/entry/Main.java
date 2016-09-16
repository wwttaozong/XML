package com.jnu.wwt.entry;

import com.jnu.wwt.node.Attribute;
import com.jnu.wwt.node.Node;
import com.jnu.wwt.dom.XMLDocument;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wwt on 2016/9/16.
 */
public class Main {

    public static void main(String args[]){

        Main main=new Main();
        Map<String,String> params=main.checkAndParseArgs(args);

        //构造题意中的xml文档
        XMLDocument document=new XMLDocument();
        if(params != null){
            if(params.containsKey("encoder") && params.get("encoder") != null){
                document.setEncoder(params.get("encoder"));
            }
            if(params.containsKey("version") && params.get("version") != null){
                document.setVersion(params.get("version"));
            }
        }
        Node root=new Node("CategoryList");
        Node child=new Node("Category");
        child.addAttribute(new Attribute("ID","01"));
        Node grandChild1=new Node("MainCategory");
        grandChild1.setText("XML");
        Node grandChild2=new Node("Description");
        grandChild2.setText("This is a list my XML articles.");
        Node grandChild3=new Node("Active");
        grandChild3.setText("true");
        child.addChild(grandChild1);
        child.addChild(grandChild2);
        child.addChild(grandChild3);
        root.addChild(child);
        document.setRoot(root);
        document.print();
    }

    /**
     * 参数检查和获取，实际中应该提供更友好的UI和交互给用户
     * @param args
     * @return
     */
    private Map<String,String> checkAndParseArgs(String args[]){
        Map<String,String> params=new HashMap<String,String>();
        if(args.length > 0){
            params.put("encoder",args[0]);
        }
        if(args.length > 1){
            params.put("version",args[1]);
        }
        return params;
    }

}
