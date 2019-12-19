package is;


public class C {

		PersonRegister register = new PersonRegister(); //referarer till klassen PersonRegister
		Person p = new Person();
		Account1 a; 
		JFrame customerFrame;

		public void addPerson(Person p) {
			register.addPerson(p);
		}

		public Person removePerson(String pNbr) {
			return register.removePerson(pNbr);
		}
		
		public Person findPerson(String pNbr) {
			return register.findPerson(pNbr); 
		}
		public void addAccount(Account1 a, Person p){
			p.addAccount(a);
			a.setOwner(p);
		}
		public void credit(double amount, String pNbr, String nbr){
			Account1 tmpAcc = findSpecificAccount(pNbr, nbr);
			if(tmpAcc != null){
				tmpAcc.credit(amount);
			}
		}
		public void withdraw (double amount, String pNbr, String nbr){
			Account1 tmpAcc = findSpecificAccount(pNbr,nbr);
			if(tmpAcc != null){
				tmpAcc.withdraw(amount);
			}
		}
		public ArrayList<Account1> findPersonAccounts (String pNbr) {
			return register.findPersonAccounts(pNbr);
		}
		public void setOwner(Person p){
			
		}
		public Account1 findSpecificAccount (String pNbr, String nbr){
			ArrayList<Account1> tmpList = register.findPersonAccounts(pNbr);
			if (tmpList != null) {
				for (Account1 a : tmpList) {
					if (a.getNbr().equals(nbr)) {
						return a;
					}	
				}
			}
			return null;
		}

	}	
		
}
