package file.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.NotSerializableException;

class Object_write {

	public static void main(String[] args) throws IOException,NotSerializableException{
 ObjectOutputStream out = null;
        
        try {
            out = new ObjectOutputStream(new
                    BufferedOutputStream(new FileOutputStream("ObjectFile")));
					Person ob = new Person("ram",23,"Rammu","geeta");
					out.writeObject(ob);
					
            
        } finally {
            out.close();
        }

	}
}
