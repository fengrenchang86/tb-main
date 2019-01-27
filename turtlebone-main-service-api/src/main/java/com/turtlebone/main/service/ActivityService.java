
package com.turtlebone.main.service;

import java.util.List;

import com.turtlebone.main.model.ActivityModel;

public interface ActivityService{
	
	public int create(ActivityModel activityModel);
	
	public int createSelective(ActivityModel activityModel);
	
	public ActivityModel findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(ActivityModel activityModel);
	
	public int updateByPrimaryKeySelective(ActivityModel activityModel);
	
	public int deleteByPrimaryKey(Integer id);

	public int selectCount(ActivityModel activityModel);
	
	public List<ActivityModel> selectByCondition(String username, String type, 
			String dateFrom, String dateTo, Integer size, Integer offset);
	
}