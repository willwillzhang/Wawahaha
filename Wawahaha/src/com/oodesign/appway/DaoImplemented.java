package com.oodesign.appway;

public class DaoImplemented implements Dao{

	@Override
	public Address getFirstAddressOfClient(Client client) {
		if (client.getAddresses != null)
			return (client.getAddresses()).get(0);
		else
			return null;
	}

	@Override
	public List<Account> getCheckingAccountsForClient(Client client, String identifier) {
			List<Account> ants = new ArrayList<Account>();
			for(Account acc : client.getAccounts){
				if(account.getIdentifier.equals("Checking"))
					ants.add(acc);
			}
			return ants;
	}

	@Override
	public void copyIdentificaitonInfoToCient(Client client1, Client client2) {
		String temp = client1.getIden();
		client1.setIden(client2.getIden);
		client2.setIden(temp);
	}

}
