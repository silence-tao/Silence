package com.silencetao.service.message;

import java.util.List;

import com.silencetao.entity.Message;
import com.silencetao.view.MessageView;

/**
 * 留言模块Service层接口
 * @author Silence
 *
 */
public interface MessageService {

	/**
	 * 添加一条留言
	 * @param message
	 * @return 返回添加记录的条数
	 */
	public int insertMessage(Message message);
	
	/**
	 * 获取留言
	 * @return 返回留言
	 */
	public List<MessageView> getMessages(long offset, long limit);
	
	/**
	 * 获取留言总数
	 * @return
	 */
	public long getMessageNum();
	
	/**
	 * 获取留言回复
	 * @param fatherId
	 * @return
	 */
	public List<MessageView> getReplies(long fatherId);
	
	/**
	 * 获取留言主页显示数据
	 * @return
	 */
	public List<MessageView> getMessageHome();
	
	/**
	 * 设置是否在首页显示
	 * @param message
	 * @return
	 */
	public int updateHomeShow(Message message);
}
