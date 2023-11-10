package com.samprakash;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConsoleApplication {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Set<String> path1=new HashSet<>();
		List<String> path=new ArrayList<>();
		listOfPackage("src/", path1);
		path.addAll(path1);
		String currentPackage=ConsoleApplication.class.getPackage().getName();
		System.out.println("\n\tWelcome to Java ConsoleApplication");
		boolean b=true;
		Scanner sc= new Scanner(System.in);
		System.out.println("***************");
		do {
			int i=1;
			for (String string : path) {
				if(string.equals(currentPackage))
					continue;
				System.out.println(i++ +" - "+string.substring(currentPackage.length()+1));
			}
			System.out.println("0 - Exit");
			System.out.println("*************");
			System.out.print("Enter the choice");
			
			int input=sc.nextInt();
			if(input==0) {
				b=false;
			}
			else {
				String classname=path.get(input-1)+".Demo";
				Class myClass = null;
				try {
					myClass=Class.forName(classname);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myClass.getDeclaredMethod("myMain", null).invoke(new ConsoleApplication(), null);
			}
			System.out.println("*************");
		} while (b);
		System.out.println("Thank You");
	}
	public static void listOfPackage(String directoryName, Set<String> pack) {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                String path=file.getPath();
                String packName=path.substring(path.indexOf("src")+4, path.lastIndexOf('\\'));
                pack.add(packName.replace('\\', '.'));
            } else if (file.isDirectory()) {
                listOfPackage(file.getAbsolutePath(), pack);
            }
        }
    }
}
