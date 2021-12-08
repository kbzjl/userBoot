package cn.ekgc.userBoot.pojo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <b></d>
 *
 * @Author Administrator
 * @Date 2021/12/7 15:13
 * @Version 1.0
 */
public class PageVO<E> implements Serializable {
	private static final long serialVersionUID = 815023193069280144L;
	private Integer pageNum;                 //当前页码
	private Integer pageSize;               //每页显示数量
	private List<E> list;                   //分页列表
	private Long totalSize;                 //总数量
	private Integer totalPage;              //总页数

	public PageVO(Integer pageNum, Integer pageSize) {
		if(pageNum != null && pageNum>0){
			this.pageNum = pageNum;
		}else{
			this.pageNum = 1;
		}
		if (pageSize !=null && pageSize>0){
			this.pageSize = 10;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
