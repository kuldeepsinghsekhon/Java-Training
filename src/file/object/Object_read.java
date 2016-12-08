package file.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.NotSerializableException;
class Object_read {

	public static void main(String[] args) throws IOException,NotSerializableException{
 ObjectInputStream in = null;
        
        try {
           in = new ObjectInputStream(new
                    BufferedInputStream(new FileInputStream("ObjectFile")));
					
					Person ob=(Person)in.readObject();
					System.out.println(ob.name);
					System.out.println(ob.age);
					System.out.println(ob.father);
					System.out.println(ob.mother);
            
        } catch(ClassNotFoundException e){
		
		}finally {
            in.close();
        }

	}
}