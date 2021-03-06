package buddy.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * BOARD 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Board {
	/** COMMENT_NO. */
	private Integer commentNo;

	/** BUDDY. */
	private Buddy buddy;

	/** REG_DATE. */
	private Date regDate;

	/** COMMENT_CONTENT. */
	private String commentContent;

	/** REPLY 목록. */
	private List<Reply> replyList;

	/**
	 * 생성자.
	 */
	public Board() {
		this.replyList = new ArrayList<Reply>();
	}
	public Board(int commentNo, String buddyId, Date regDate, String commentContent){
		this();
		this.commentNo = commentNo;
		this.buddy = new Buddy(buddyId);
		this.regDate = regDate;
		this.commentContent = commentContent;
	}
	public Board(String buddyId, String commentContent){
		this(0, buddyId, null, commentContent);
	}
	public Board(int commentNo, String commentContent){
		this(commentNo, null, null, commentContent);
	}
	public Board(int commentNo){
		this(commentNo, null);
	}

	/**
	 * COMMENT_NO을 설정합니다..
	 * 
	 * @param commentNo
	 *            COMMENT_NO
	 */
	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}

	/**
	 * COMMENT_NO을 가져옵니다..
	 * 
	 * @return COMMENT_NO
	 */
	public Integer getCommentNo() {
		return this.commentNo;
	}

	/**
	 * BUDDY을 설정합니다..
	 * 
	 * @param buddy
	 *            BUDDY
	 */
	public void setBuddy(Buddy buddy) {
		this.buddy = buddy;
	}

	/**
	 * BUDDY을 가져옵니다..
	 * 
	 * @return BUDDY
	 */
	public Buddy getBuddy() {
		return this.buddy;
	}

	/**
	 * REG_DATE을 설정합니다..
	 * 
	 * @param regDate
	 *            REG_DATE
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * REG_DATE을 가져옵니다..
	 * 
	 * @return REG_DATE
	 */
	public Date getRegDate() {
		return this.regDate;
	}

	/**
	 * COMMENT_CONTENT을 설정합니다..
	 * 
	 * @param commentContent
	 *            COMMENT_CONTENT
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	/**
	 * COMMENT_CONTENT을 가져옵니다..
	 * 
	 * @return COMMENT_CONTENT
	 */
	public String getCommentContent() {
		return this.commentContent;
	}

	/**
	 * REPLY 목록을 설정합니다..
	 * 
	 * @param replySet
	 *            REPLY 목록
	 */
	public void setReplySet(List<Reply> replySet) {
		this.replyList = replySet;
	}

	/**
	 * REPLY를 추가합니다..
	 * 
	 * @param reply
	 *            REPLY
	 */
	public void addReply(Reply reply) {
		this.replyList.add(reply);
	}

	/**
	 * REPLY 목록을 가져옵니다..
	 * 
	 * @return REPLY 목록
	 */
	public List<Reply> getReplyList() {
		return this.replyList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentNo == null) ? 0 : commentNo.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Board other = (Board) obj;
		if (commentNo == null) {
			if (other.commentNo != null) {
				return false;
			}
		} else if (!commentNo.equals(other.commentNo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Board [commentNo=" + commentNo + ", buddy=" + buddy + ", regDate=" + regDate + ", commentContent="
				+ commentContent + ", replySet=" + replyList + "]";
	}

}
