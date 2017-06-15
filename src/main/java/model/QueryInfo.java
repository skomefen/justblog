package model;

public class QueryInfo {
	private int current;
	private int pageSize;
	private int startIndex;
	public QueryInfo(){}
	public QueryInfo(int current, int pageSize) {
		super();
		this.current = current;
		this.pageSize = pageSize;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		this.startIndex = (this.current-1)*this.pageSize;
		return startIndex;
	}
}
