
package com.turtlebone.main.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.turtlebone.base.util.BeanCopyUtils;
import com.turtlebone.main.entity.Activity;
import com.turtlebone.main.repository.ActivityRepository;
import com.turtlebone.main.model.ActivityModel;
import com.turtlebone.main.service.ActivityService;

@Service
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = ActivityService.class)
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return activityRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public ActivityModel findByPrimaryKey(Integer id) {
		Activity activity = activityRepo.selectByPrimaryKey(id);
		return BeanCopyUtils.map(activity, ActivityModel.class);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(ActivityModel activityModel) {
		return activityRepo.updateByPrimaryKey(BeanCopyUtils.map(activityModel, Activity.class));
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(ActivityModel activityModel) {
		return activityRepo.updateByPrimaryKeySelective(BeanCopyUtils.map(activityModel, Activity.class));
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(ActivityModel activityModel) {
		return activityRepo.insert(BeanCopyUtils.map(activityModel, Activity.class));
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(ActivityModel activityModel) {
		return activityRepo.insertSelective(BeanCopyUtils.map(activityModel, Activity.class));
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(ActivityModel activityModel) {
		return activityRepo.selectCount(BeanCopyUtils.map(activityModel, Activity.class));
	}


	@Override
	public List<ActivityModel> selectByCondition(String username, String type, 
			String dateFrom, String dateTo, Integer pageSize, Integer offset) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("type", type);
		if (!StringUtils.isEmpty(dateTo) && !StringUtils.isEmpty(dateFrom)) {
			map.put("dateFrom", dateFrom);
			map.put("dateTo", dateTo);
		}
		if (pageSize != null && offset != null && pageSize > 0) {
			map.put("offset", offset);
			map.put("pageSize", pageSize);
		} else {
			map.put("offset", 0);
			map.put("pageSize", 10000);
		}
		List<Activity> list = activityRepo.selectByCondition(map);
		return BeanCopyUtils.mapList(list, ActivityModel.class);
	}

}
