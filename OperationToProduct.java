package CSD201_AS2_FX11317;

import java.io.*;

import java.util.Scanner;

public class OperationToProduct {
    Scanner sc = new Scanner(System.in);
    MyList list = new MyList();

    //tao sp
     public Product createProduct(MyList list) {
         //nhap du lieu sp
         Product newProduct = new Product();
         System.out.print("Input new ID: ");
         newProduct.setBcode(sc.next());
         System.out.print("Input Product's Name: ");
         newProduct.setTitle(sc.next());
         System.out.print("Input Product's quantity: ");
         newProduct.setQuantity(sc.nextInt());
         System.out.print("Input Product's price: ");
         newProduct.setPrice(sc.nextDouble());
         list.insertToTail(newProduct);

         return newProduct;
     }

    //lay du lieu sp tu file va luu vao linked list
     public void getAllItemsFromFile(String file, MyList list) throws IOException {
         InputStream input = new FileInputStream(file);
         InputStreamReader inputSD = new InputStreamReader(input);
         BufferedReader reader = new BufferedReader(inputSD);

         String line = "";
         while ((line = reader.readLine())  != null){
             System.out.println(line);

             Product pr = new Product();
             // xu ly chuoi de ra mang chua thong tin sp
             String[] result = line.split("\\|\t");
             pr.setBcode(result[0]);
             pr.setTitle(result[1]);
             pr.setQuantity(Integer.parseInt(result[2]));
             pr.setPrice(Double.parseDouble(result[3]));
             //them sp vao cuoi list
             list.insertToTail(pr);
         }
         writeconsole("CSD201_AS2_FX11317\\output.txt",list.toString());

         System.out.println("Successfully!");
     }

    //lay du lieu sp tu file va luu vao stack
     public void getAllItemsFromFile(String fileName, MyStack stack) throws IOException {
         InputStream input = new FileInputStream(fileName);
         InputStreamReader inputSD = new InputStreamReader(input);
         BufferedReader reader = new BufferedReader(inputSD);

         String line = "";
         while ((line = reader.readLine())  != null){

             Product pr = new Product();
             // xu ly chuoi de ra mang chua thong tin sp
             String[] result = line.split("\\|\t");
             pr.setBcode(result[0]);
             pr.setTitle(result[1]);
             pr.setQuantity(Integer.parseInt(result[2]));
             pr.setPrice(Double.parseDouble(result[3]));
             //day sp vao stack
             stack.push(pr);
         }
         System.out.println(stack);
         writeconsole("CSD201_AS2_FX11317\\output.txt",stack.toString());

         System.out.println("Successfully!");
     }

    //lay du lieu sp tu file va luu vao queue
     public void getAllItemsFromFile(String fileName, MyQueue queue) throws IOException {
         InputStream input = new FileInputStream(fileName);
         InputStreamReader inputSD = new InputStreamReader(input);
         BufferedReader reader = new BufferedReader(inputSD);

         String line = "";
         while ((line = reader.readLine())  != null){

             Product pr = new Product();
             // xu ly chuoi de ra mang chua thong tin sp
             String[] result = line.split("\\|\t");
             pr.setBcode(result[0]);
             pr.setTitle(result[1]);
             pr.setQuantity(Integer.parseInt(result[2]));
             pr.setPrice(Double.parseDouble(result[3]));
             //day sp vao queue
             queue.enqueue(pr);
         }

         System.out.println(queue);
         writeconsole("CSD201_AS2_FX11317\\output.txt",queue.toString());


         System.out.println("Success!");
     }

     public void writeAllItemsToFile(String fileName, MyList list) {
         try{
             //b1 tao luong va lk nguon dl
             OutputStream output = new FileOutputStream(fileName);
             OutputStreamWriter writeFile = new OutputStreamWriter(output);
             //b2 ghi du lieu
             writeFile.write(list.toString());
             writeFile.flush();

         } catch (IOException e){
             System.out.println("Fail!");
         }
         System.out.println("Successfully!");
     }
    //luu console
    public void writeconsole(String fileName, String string) {
        try{
            //Specify the file name and path here
            File file =new File(fileName);

            // neu file chua ton tai
            if(!file.exists()){
                file.createNewFile();
            }

            //them du lieu vao file
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(string);
            bw.write("=================================\n");
            //dong luong
            bw.close();

        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }


     public void danhsachSP(MyList list){
         list.insertToTail(new Product("P03", "Sugar", 12, 25.1));
         list.insertToTail(new Product("P01", "Miliket", 10, 5.2));
         list.insertToTail(new Product("P02", "Apple", 5, 4.3));
         list.insertToTail(new Product("P05", "Rose", 7, 15.4));
         list.insertToTail(new Product("P07", "Beer", 11, 12.2));
         list.insertToTail(new Product("P04", "Book", 9, 5.2));
         list.insertToTail(new Product("3", "3", 3, 3.0));
         list.insertToTail(new Product("4", "4", 4, 4.0));
     }
}
