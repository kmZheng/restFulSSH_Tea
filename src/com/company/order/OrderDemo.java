package com.company.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDemo {

	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		int random = (int) (Math.random() * 19);

		list.add("姜天");
		list.add("申和林");
		list.add("于雷");
		list.add("郑凯明");
		list.add("王春洋");
		list.add("李莲莲");
		list.add("郭晓薇");
		list.add("王永健");
		list.add("赵壮");
		list.add("麻福君");
		list.add("王浩");
		list.add("王宁");
		list.add("马宁");
		list.add("于新程");
		list.add("吕昕蒙");
		list.add("张鸿鹏");
		list.add("董思琪");
		list.add("高帅");
		list.add("张晓敏");

		System.out.println(list.get(random));

		Scanner scanner = new Scanner(System.in);
		while (true) {
			int random1 = (int) (Math.random() * 19);
			scanner.nextInt();
			System.out.println(list.get(random1));
		}
	}
}
