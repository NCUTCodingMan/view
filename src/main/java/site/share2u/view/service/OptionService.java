package site.share2u.view.service;

import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.json.GsonOption;
import site.share2u.view.pojo.Column;
import site.share2u.view.pojo.Dimension;
import site.share2u.view.pojo.Measure;
import site.share2u.view.pojo.OptionView;

import java.util.List;
import java.util.Map;

public interface OptionService {
	/**
	 * 根据维度和度量推荐图表
	 * @return 返回可以采用的图表类型
	 */
	public List<SeriesType> getTypes(String tableName,List<Dimension> types, List<Measure> measures);


//	/**
//	 * 根据图表等一些参数画图
//	 * @param dimension 维度项
//	 * @param measures 度量项
//	 * @param seriesType 图表类型
//	 * @return 图表option
//	 */
//	public GsonOption getOption(String tableName,List<Column> dimension,Map<String,Column> measures,SeriesType seriesType);

	/**
	 * 获取对应仪表盘的option信息
	 * @param dashboardId 仪表盘id
	 * @return
	 */
	public List<OptionView>  getOptionByDashboardId(Integer dashboardId);
}
