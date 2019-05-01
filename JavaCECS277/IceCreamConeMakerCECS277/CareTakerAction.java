/*Nikki Nguyen
  October 23, 2017
  Purpose: CareTaker class reads and writes an object from a file
  Inputs: ice cream memento
  Output: memento saved to a file
*/

import  java.io.*;
/**
 * class reads and writes an object from a file
 * @author NikkiNguyen
 */
public class CareTakerAction{
    ObjectOutputStream oos = null;
    MementoIceCreamCone iceCream = null;
    /**
     * writes object to file
     * @param iceCream
     * @throws IOException
     */
    public void addMemento(MementoIceCreamCone iceCream) throws IOException{
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IceCream.data"));
            oos.writeObject(iceCream);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * reads object on file
     * @param flavor
     * @return iceCream
     * @throws IOException
     */
    public MementoIceCreamCone getMemento(String flavor) throws IOException{
        //for some reason, oos.close did not like it here
        //oos.close();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IceCream.data"));
            //do while flavor does not equal flavor
            do{
                iceCream = (MementoIceCreamCone) ois.readObject();
            }while(!iceCream.getFlavor().equals(flavor));
	} catch(FileNotFoundException fnf){
            System.out.println("File was not found.");
        }catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException cnf){
            System.out.println("Class not found.");
        }
        return iceCream;
    }
}
