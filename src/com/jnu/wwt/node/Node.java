package com.jnu.wwt.node;

import java.util.*;

/**
 * Created by wwt on 2016/9/16.
 */
public class Node {

    /**
     * 节点名称
     */
    private String name;

    /**
     * 属性
     */
    private Map<String,String> attributes;

    /**
     * 文本节点
     */
    private String text;

    /**
     * 父节点
     */
    private Node parent;

    /**
     * 子节点
     */
    private List<Node> childs;

    public Node(){

    }

    public Node(String name){
        this.name=name;
    }

    /**
     * 添加子节点
     * @param node
     * @return
     */
    public void addChild(Node node){
        if(childs == null){
            childs=new ArrayList<Node>();
        }
        if(node == null){
            return ;
        }
        if(node.getParent() != null){
            if(node.getParent() == this && childs.contains(node)){
                return ;
            }else{
                //实际中应该使用日志或是其他补偿工具
                System.out.println("该节点已经有其他的父节点");
                System.exit(1);
            }
        }
        node.setParent(this);
        childs.add(node);
    }

    /**
     * 删除子节点
     * @param node
     * @return
     */
    public void deleteChild(Node node){
        if(node == null){
            return ;
        }
        if(childs == null || childs.isEmpty()){
            //实际中应该使用日志或是其他补偿工具
            System.out.println("该节点没有子节点");
            System.exit(1);
        }
        if(node.getParent() == this && childs.contains(node)){
            node.setParent(null);
            childs.remove(node);
            return ;
        }else{
            //实际中应该使用日志或是其他补偿工具
            System.out.println("该节点没有该子节点");
            System.exit(1);
        }
    }

    /**
     * 添加节点属性
     * @param attribute
     * @return
     */
    public void addAttribute(Attribute attribute){
        if(attributes == null){
            attributes=new HashMap<String,String>();
        }
        if(attribute == null){
            return ;
        }
        if(attribute.getKey() == null || attribute.getValue() == null){
            //实际中应该使用日志或是其他补偿工具
            System.out.println("传入属性不完整");
            System.exit(1);
        }
        String key=attribute.getKey();
        String value=attribute.getValue();
        if(attributes.containsKey(key) && attributes.get(key).equals(value)){
            return ;
        }else{
            attributes.put(key,value);
            return ;
        }
    }

    /**
     * 打印当前节点和其所有的子孙节点，这里是为了对外提供更加友好的接口，不需关心参数。
     */
    public void print(){
        System.out.println(doPrint(this,new StringBuilder()));
    }

    private String doPrint(Node node,StringBuilder sb){
        sb.append("<");
        sb.append(node.getName());
        if(node.getAttributes() != null && !node.getAttributes().isEmpty()){
            for(Map.Entry<String, String> entry:node.getAttributes().entrySet()){
                sb.append(" ");
                sb.append(entry.getKey()+"="+"\""+entry.getValue()+"\"");
            }
        }
        sb.append(">");
        if(node.getText() != null){
            sb.append(node.getText());
        }else{
            sb.append("\n");
        }
        if(node.getChilds() != null && !node.getChilds().isEmpty()){
            for(Node child:node.getChilds()){
                doPrint(child,sb);
            }
        }
        sb.append("</"+node.getName()+">\n");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", parent=" + parent +
                ", childs=" + childs +
                '}';
    }
}
