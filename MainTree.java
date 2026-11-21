import java.util.Scanner;                                         

public class MainTree {                                             
    public static void main(String[] args) {                
        Scanner input = new Scanner(System.in);                        

        SubClassTree tree = new SubClassTree();                        

        System.out.print("Enter number of elements: ");               
        int n = input.nextInt();                                       

        if (n < 0 || n > 100) {                                        
            System.out.println("Enter a number from 0 to 100.");       
            input.close();                                             
            return;                                                     
        }                                                              

        for (int i = 0; i < n; i++) {                                   
            System.out.print("Enter value: ");                          
            int value = input.nextInt();                                

            tree.insert(value);                                        
        }                                                              

        System.out.print("In-order Traversal: ");                      
        tree.inOrder(0);                                       
        System.out.println();                                         

        System.out.print("Enter value to search: ");                    
        int target = input.nextInt();                                 

        int foundIndex = tree.search(0, target);                 
 
        if (foundIndex != -1) {                                    
            System.out.println("Found " + target                     
                    + " at array index " + foundIndex);              
        } else {                                                       
            System.out.println(target + " not found.");               
        }                                                              

        input.close();                                                 
    }                                                              
}                                                                     

public class SubClassTree extends AbstractClassTree {                 
    void insert(int val) {                                             
        if (size >= 100) return;                                       

        tree[size] = val;                                               
        size++;                                                         
    }                                                                  

    int search(int index, int val) {                                   
        if (index >= size) {                                            
            return -1;                                                
        }                                                              

        if (tree[index] == val) {                                     
            return index;                                              
        }                                                             
 
        int leftResult = search(2 * index + 1, val);                   

        if (leftResult != -1) return leftResult;                       

        return search(2 * index + 2, val);                              
    }                                                                  

    void inOrder(int index) {                                         
        if (index >= size) {                                          
            return;                                                    
        }                                                             

        inOrder(2 * index + 1);                                      

        System.out.print(tree[index] + " ");                           

        inOrder(2 * index + 2);                                       
    }                                                                  
}                                                                      

public abstract class AbstractClassTree {                             
    int[] tree = new int[100];                                         
    int size = 0;                                                       

    abstract void insert(int val);
  
    abstract int search(int index, int val);                       

    abstract void inOrder(int index);                                   
}                                                                     
