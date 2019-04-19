package stack;

public class ArrayStack {

    private static final int MAX_SIZE = 10;

    String[] stack  = new String[MAX_SIZE];

    private int index;



    public boolean push(String item){

        if(index>MAX_SIZE){
            return false;
        }
        stack[index++] = item;
        return true;
    }

    public String pop(){
        if(index -1 <0){
            return "";
        }
        return stack[--index];
    }


    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack();
        stack.push("123");
        stack.push("234");
        stack.push("56");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("qwe");
        System.out.println(stack.pop());


    }



}
