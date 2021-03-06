package site.share2u.view.util;

import java.util.ArrayList;
import java.util.List;

import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.ParallelAxis;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Parallel;
import com.github.abel533.echarts.series.Series;

import edu.emory.mathcs.backport.java.util.Arrays;

public class CEcharts {
	String[] icons = { "triangle", "circle", "rect", "roundRect", "diamond", "pin", "arrow" };

	/**
	 * 直角坐标系下的散点图,折线图，柱状图 
	 * 
	 * @param series
	 *            List<List<List<Object>>> series list<list>为某一个系列 list
	 *            <object> 四个数值 x,y,大小，标签
	 * @return
	 */
	public GsonOption setScatterOption(Title title, Legend legend, List<Axis> xAxis, List<Axis> yAxis,
			List<Series> series){
		return setXYOption(title, legend, null, xAxis, yAxis, series);
	}

	/**
	 * 设置饼图的option
	 * @param title
	 * @param legend
	 * @param series,,data里是json对象value:ss,name:"ss"
	 * @return
	 */
	public GsonOption setPieOption(Title title, Legend legend,List<Series> series){
		return setXYOption(title, legend, null, null, null, series);
	}
	
	
	/**
	 * 设置直角坐标系下的option
	 */
	private GsonOption setXYOption(Title title, Legend legend, Grid grid, List<Axis> xAxis, List<Axis> yAxis,
			List<Series> series) {
		GsonOption option = new GsonOption();
		if (title != null)
			option.setTitle(title);// 标题
		if (legend != null)
			option.setLegend(legend);// 图列
		if (grid != null)
			option.setGrid(grid);// 网格
		if (xAxis != null)
			option.setxAxis(xAxis);// x轴
		if (yAxis != null)
			option.setyAxis(yAxis);// y轴
		if (series != null)
			option.setSeries(series);// 系列数据
		return option;
	}

	public static  GsonOption setParallelOption(Title title,List<? super List<Object>> data,List<ParallelAxis> parallelAxis){
		ParallelOption option = new ParallelOption();
		Parallel parallel = new Parallel();
		parallel.setData(data );
		List<Series> series = new ArrayList<>();
		series.add(parallel);
		option.setSeries(series);;//数据
		option.setParallelAxis(parallelAxis);//平行坐标轴
		option.setTitle(title);//标题
		return option;
	}
	public static void main(String[] args) {
		List<List<Object>> data = new ArrayList<>();
		ArrayList<Object> a1 = new ArrayList<>(Arrays.asList(new Object[]{1,55,"良"}));
		ArrayList<Object> a2 = new ArrayList<>(Arrays.asList(new Object[]{2,57,"中"}));
		data.add(a1);
		data.add(a2);
		
		List<ParallelAxis> parallelAxis = new ArrayList<>();
		ParallelAxis p1 = new ParallelAxis();
		p1.setDim(0);
		p1.setName("编号");
		
		ParallelAxis p2 = new ParallelAxis();
		p2.setDim(1);
		p2.setName("aoi");
		
		ParallelAxis p3 = new ParallelAxis();
		p3.setDim(2);
		p3.setType(AxisType.category);
		p3.setName("等级");
		p3.setData(Arrays.asList(new String[]{"良","中"}));
		
		parallelAxis.add(p1);
		parallelAxis.add(p2);
		parallelAxis.add(p3);
		
		
		Title title = new Title();
		title.setText("默认标题");
		setParallelOption(title ,data,parallelAxis);
	}
	
}
