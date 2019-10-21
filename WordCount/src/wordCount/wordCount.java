package wordCount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
//code modified from : https://blog.csdn.net/u012580143/article/details/82987379
public class wordCount {
	static HashMap<String, Integer > hashMap=new HashMap<String,Integer>();
	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		wordCount wc = new wordCount();
		try {
			wc.count("/Users/ziyi/document/cs1699/hw3/files/11MB.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wc.count("/Users/ziyi/document/cs1699/hw3/files/10MB.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wc.count("/Users/ziyi/document/cs1699/hw3/files/9MB.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Long endTime = System.currentTimeMillis();
		wc.result();	
		System.out.println("-----------------------------");
		System.out.println("time used : " + (endTime - startTime) + "ms");
	}
	
	public void count(String src) throws FileNotFoundException {
		System.out.println(src);
		File file=new File(src);
		if(!file.exists()){
			System.out.println("file not found.");
			return;
		}
		Scanner scanner=new Scanner(file);
		while(scanner.hasNextLine()){
			String line=scanner.nextLine();
			//\w+ : 匹配所有的单词
			//\W+ : 匹配所有非单词
			String[] lineWords=line.split("\\W+");//用非单词符来做分割，分割出来的就是一个个单词
			
			Set<String> wordSet=hashMap.keySet();
			for(int i=0;i<lineWords.length;i++){
				lineWords[i] = lineWords[i].toLowerCase();
				if(wordSet.contains(lineWords[i])){
					Integer number=hashMap.get(lineWords[i]);
					number++;
					hashMap.put(lineWords[i], number);
				}else {
					hashMap.put(lineWords[i], 1);
				}
			}
		}
		System.out.println("current file counted.");
		scanner.close();
	}
	
	public void result() {
		System.out.println("-----------------------------");
		Iterator<String> iterator=hashMap.keySet().iterator();

		File writename = new File("/Users/ziyi/document/cs1699/hw3/files/output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
		BufferedWriter out;
		try {
			writename.createNewFile();
			out = new BufferedWriter(new FileWriter(writename));
			while(iterator.hasNext()){
				String word=iterator.next();
				System.out.printf("%-12s count:%d\n",word,hashMap.get(word));
				out.write(word +" : " + hashMap.get(word) + "\n"); 
			}
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
