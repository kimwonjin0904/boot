package com.future.my.push;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import nl.martijndwars.webpush.Subscription;

@Component //spring이 관리하는 싱글톤 bean [구독정보를 전역적으로 관리]
public class SubscriptionRepo {
	private ArrayList<Subscription> subList = new ArrayList<>();

	public ArrayList<Subscription> getSubList() {
		return subList;
	}

	public void setSubList(ArrayList<Subscription> subList) {
		this.subList = subList;
	}
	public void addSub(Subscription sub) {
		subList.add(sub); //구독자 정보 추가
	}
}
