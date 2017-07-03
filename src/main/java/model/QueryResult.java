package model;

import java.util.List;

/**
 * @author Oliver
 *
 */
public class QueryResult {
	private	List result;
	private int total;
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "QueryResult [result=" + result + ", total=" + total + "]";
	}
	
}
