package com.demo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Bank {
	private String bankName;
	private List<Account> accounts;
	private Map<String, Integer> customerCount;//map
	
	private Map<String, BranchLocation> branches;
	
	private Map<String, String> branchManagers;//prop
	
	
	
	
	public void setBranchManagers(Map<String, String> branchManagers) {
		this.branchManagers = branchManagers;
	}

	public void setBranches(Map<String, BranchLocation> branches) {
		this.branches = branches;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setCustomerCount(Map<String, Integer> customerCount) {
		this.customerCount = customerCount;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void printDetails() {
		System.out.println("bank name: " + bankName);
		System.out.println("accounts in bank");
		accounts.forEach(a -> System.out.println(a));

		Set<Entry<String, Integer>> entrySet = customerCount.entrySet();
		for(Entry<String, Integer> entry: entrySet) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
		
		System.out.println("-------branch informations------------");
		Set<Entry<String, BranchLocation>> entrySet2 = branches.entrySet();
		for(Entry<String, BranchLocation> entry: entrySet2) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
		
		System.out.println("------------branchManagers----------------");
		Set<Entry<String, String>> entrySet3 = branchManagers.entrySet();
		for(Entry<String, String> entry: entrySet3) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
	}

}













