package fleanza.tennis.impl;

import fleanza.tennis.spec.Player;

public class Single implements Player {

	private String name;

	public Single(String aName) {

		if(aName == null) {
			throw new NullPointerException("Name param NULL");
		}

		if(aName.trim().isEmpty()) {
			throw new IllegalArgumentException("Name param EMPTY");
		}

		name = aName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}

		if(obj == null) {
			return false;
		}

		if(getClass() != obj.getClass()) {
			return false;
		}

		Single other = (Single)obj;
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}
		else if(!name.equals(other.name)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return String.format("Single[%s]",getName());
	}
}
