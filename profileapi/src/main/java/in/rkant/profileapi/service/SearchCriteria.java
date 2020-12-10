package in.rkant.profileapi.service;

public class SearchCriteria {

	private String key;
	private String operation;
	private Object value;
	private String perdicateType;
	public SearchCriteria() {}
	public SearchCriteria(String key, String operation, Object value, String perdicateType) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
		this.perdicateType = perdicateType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getPerdicateType() {
		return perdicateType;
	}

	public void setPerdicateType(String perdicateType) {
		this.perdicateType = perdicateType;
	}

}
