package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
class Module_7 {

    @Test
// Saves obejects and checks if they are successfully serialized and read

    void objectSuccessfullySerializedAndRead() {
        // Saves Objects in Disk
        try (FileOutputStream fs = new FileOutputStream("objects.txt")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            Burger b = new Burger();
            os.writeObject(b);

            os.close();
        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileInputStream fi = new FileInputStream("objects.txt")) {
            ObjectInputStream os = new ObjectInputStream(fi);

            Burger b1 = (Burger) os.readObject();

          // Check if object was serialized and read
            assertEquals(true, b1.foodChose());

            os.close();

        } catch (
                FileSystemNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}