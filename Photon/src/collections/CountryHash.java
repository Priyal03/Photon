package collections;

public class CountryHash {

		String name;  
		long population;  
	 
		public CountryHash(String name, long population) {  
			super();  
			this.name = name;  
			this.population = population;  
		}  
		public String getName() {  
			return name;  
		}  
		public void setName(String name) {  
			this.name = name;  
		}  
		public long getPopulation() {  
			return population;  
		}  
		public void setPopulation(long population) {  
			this.population = population;  
		}
	 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + (int) (population ^ (population >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CountryHash other = (CountryHash) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	 
	   @Override
		public String toString() {
			
			return "Country: "+name+" | population:"+population;
		}
	}  //go to Vehicle class for sorting in hashmaps
