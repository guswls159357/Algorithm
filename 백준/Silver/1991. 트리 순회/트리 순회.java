import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char value;
        Node left;
        Node right;
        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> nodes = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        char curNodeValue;
        char leftNodeValue;
        char rightNodeValue;

        Node node;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            curNodeValue = st.nextToken().charAt(0);
            leftNodeValue = st.nextToken().charAt(0);
            rightNodeValue = st.nextToken().charAt(0);

            boolean existCurNode = nodes.containsKey(curNodeValue);
            boolean existLeftNode = nodes.containsKey(leftNodeValue);
            boolean existRightNode = nodes.containsKey(rightNodeValue);

            if(existCurNode){
                node = nodes.get(curNodeValue);
            }else {
                node = new Node(curNodeValue, null, null);
                nodes.put(curNodeValue, node);
            }

            if (leftNodeValue != '.'){
                if(existLeftNode){
                    node.left = nodes.get(leftNodeValue);
                }else{
                    node.left = new Node(leftNodeValue, null, null);
                }
                nodes.put(leftNodeValue, node.left);
            }

            if(rightNodeValue != '.'){
                if(existRightNode){
                    node.right = nodes.get(rightNodeValue);
                }else{
                    node.right = new Node(rightNodeValue, null, null);
                }
                nodes.put(rightNodeValue, node.right);
            }

        }

        //printNodes();

        preOrder(nodes.get('A'));
        System.out.println(sb);
        sb = new StringBuilder();

        midOrder(nodes.get('A'));
        System.out.println(sb);
        sb = new StringBuilder();

        postOrder(nodes.get('A'));
        System.out.println(sb);
    }

    static void preOrder(Node node){

        if(node == null) return;

        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void midOrder(Node node){

        if(node == null) return;

        midOrder(node.left);
        sb.append(node.value);
        midOrder(node.right);
    }

    static void postOrder(Node node){

        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }

    static void printNodes(){

        for(char key : nodes.keySet()){
            Node node = nodes.get(key);
            System.out.println("value : " + node.value);
            if(node.left != null){
                System.out.println("left : " + node.left.value);
            }
            if(node.right != null){
                System.out.println("right : " + node.right.value);
            }
            System.out.println();
        }

    }

}
