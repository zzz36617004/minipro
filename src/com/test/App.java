package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		boolean esc = true;
		
		while (esc) {
			System.out.println("--------------------------------------");
			System.out.println("1.리스트    2.등록    3.삭제    4.검색    5. 종료");
			System.out.println("--------------------------------------");

			System.out.print(">메뉴번호:");
			int i = sc.nextInt();

			if (i == 1) {
				System.out.println("<1.리스트>");
				Reader fr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(fr);
				ArrayList<DB> c = new ArrayList<DB>();
				while (true) {

					String line = br.readLine();
					if (line == null)
						break;
					String b[] = line.split(",");
					c.add(new DB(b[0], b[1], b[2]));
				}

				for (int i1 = 0; i1 < c.size(); i1++) {
					System.out.print(i1+1+". ");
					c.get(i1).showinfo();
				}
				br.close();
			} else if (i == 2) {
				System.out.println("<2.등록>");
				ArrayList<DB> c = new ArrayList<DB>();
				Reader fr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					String b[] = line.split(",");
					c.add(new DB(b[0], b[1], b[2]));
				}
				
				System.out.print("name:");
				String name = sc.next();
				System.out.print("phone:");
				String ph = sc.next();
				System.out.print("company:");
				String com = sc.next();
				c.add(new DB(name, ph, com));

				Writer osw = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(osw);
				for (int i1 = 0; i1 < c.size(); i1++) {
					bw.write(c.get(i1).getName() + "," + c.get(i1).getNum() + "," + c.get(i1).getCompany());
					bw.newLine();
				}
				br.close();
				bw.close();
			} else if (i == 3) {
				System.out.println("<3.삭제>");
				ArrayList<DB> c = new ArrayList<DB>();
				Reader fr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					String b[] = line.split(",");
					c.add(new DB(b[0], b[1], b[2]));
				}
				System.out.print(">번호:");
				int idex = sc.nextInt();
				c.remove(idex-1);
				Writer osw = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(osw);
				for (int i1 = 0; i1 < c.size(); i1++) {
					bw.write(c.get(i1).getName() + "," + c.get(i1).getNum() + "," + c.get(i1).getCompany());
					bw.newLine();
				}
				bw.close();
				br.close();

			} else if (i == 4) {
				System.out.println("<4.검색>");
				Reader fr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(fr);
				ArrayList<DB> c = new ArrayList<DB>();
				while (true) {

					String line = br.readLine();
					if (line == null)
						break;
					String b[] = line.split(",");
					c.add(new DB(b[0], b[1], b[2]));
				}
				System.out.print(">문자입력:");
				String n=sc.next();
				for(i=0;i<c.size();i++) {
					
				boolean f=c.get(i).getName().contains(n);
				if(f==true) {
					c.get(i).showinfo();
				}
				}
			} else if (i == 5) {
				esc = false;
				System.out.println("종료할게요");
			} else {
				System.out.println("다시입력하세요");
			}
		}

	}

}
