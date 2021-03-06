package org.deta.boot.vpc.controller;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JTextPane;

import org.MS.plsql.cache.DetaDBBufferCacheManager;
//import java.net.ServerSocket;
//import java.util.Properties;
import org.deta.boot.vpc.process.TimeProcess;
import org.deta.boot.vpc.sleeper.Sleeper;
import org.deta.boot.vpc.sleeper.SleeperHall;
import org.deta.vpcs.hall.DatabaseLogHall;
import org.plsql.common.utils.DetaUtil;
import org.plsql.stable.StableData;

import ME.sample.App;
public class ServerInitController {
	private static ServerSocket server;
	//private static Properties properties;
	private static int port;
	static {
		//properties = new Properties();
//		try {
//			properties.load(new FileInputStream
//					(new File("src/main/resources/property.proterties")));
//			System.out.println("----德塔VPCS数据库服务器资源载入:成功！");
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static void initService(JTextPane jTextPane) throws IOException {
		try {
			//port= Integer.parseInt(properties.getProperty(StableData.TCP_PORT));
			port= 8000;
			server= new ServerSocket(port);
			System.out.println("----德塔VPCS数据库服务器端口启动:" + port);
			if(jTextPane!= null) {
				String text= jTextPane.getText();
				text="\r\n"+ "----德塔VPCS数据库服务器端口启动:" + port+ text;
				text="\r\n"+ "..."+ text;
				jTextPane.setText(text);
			}
			DetaUtil.initDB();
			System.out.println("----德塔VPCS数据库服务器DMA确认:成功！");
			if(jTextPane!= null) {
				String text= jTextPane.getText();
				text="\r\n"+ "----德塔VPCS数据库服务器DMA确认:成功！"+ text;
				text="\r\n"+ "...";
				jTextPane.setText(text);
			}
			RequestFilterController.initBlockList();
			System.out.println("----德塔VPCS数据库服务器IP过滤服务启动:成功！");
			if(jTextPane!= null) {
				String text= jTextPane.getText();
				text="\r\n"+ "----德塔VPCS数据库服务器IP过滤服务启动:成功！"+ text;
				text="\r\n"+ "...";
				jTextPane.setText(text);
			}
			DetaDBBufferCacheManager.reflection();
			System.out.println("----德塔VPCS数据库服务器启动整库过程映射服务:成功！");
			if(jTextPane!= null) {
				String text= jTextPane.getText();
				text="\r\n"+ "----德塔VPCS数据库服务器启动整库过程映射服务:成功！"+ text;
				text="\r\n"+ "...";
				jTextPane.setText(text);
			}
			DatabaseLogHall.createBinLogHall();
			System.out.println("----德塔VPCS数据库服务器启动整库过程映射服务:成功！");
			if(jTextPane!= null) {
				String text= jTextPane.getText();
				text="\r\n"+ "----德塔VPCS数据库服务器启动整库过程映射服务:成功！"+ text;;
				text="\r\n"+ "...";
				jTextPane.setText(text);
			}
			//			BootBackup.bootBackupByUsingGzip(CacheManager
			//.getCacheInfo("LogPath").getValue().toString()+"/zipCover");
			//			UnZip.unZipWithPath("C:/DetaLog/zipCover/zip_1549583065203.zip"
			//, "C:/DetaLog/zipCover/cover");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void haoHiYooFaker(SleeperHall sleeperHall) {
		sleeperHall.callSkivvy(); 
	}

	public static void initServer(App app) throws IOException {
		System.out.println("----DETA VPCS--1.8");
		System.out.println("----Author: 罗瑶光");
		System.out.println("----浏阳德塔软件开发有限公司开源项目");
		if(app.appConfig.SectionJPanel.jTextPane!= null) {
			String text= app.appConfig.SectionJPanel.jTextPane.getText();
			text="\r\n"+ "载入德塔 PLSQL数据库 映射添加完毕！"+ text;
			text="\r\n"+ "----Author: 罗瑶光"+ text;
			text="\r\n"+ "----浏阳德塔软件开发有限公司开源项目"+ text;
			text="\r\n"+ "..."+ text;
			app.appConfig.SectionJPanel.jTextPane.setText(text);
		}
		TimeProcess timeProcess= new TimeProcess();
		timeProcess.begin();
		SleeperHall sleeperHall = new SleeperHall();
		initService(app.appConfig.SectionJPanel.jTextPane);
		timeProcess.end();
		if(app.appConfig.SectionJPanel.jTextPane!= null) {
			String text= app.appConfig.SectionJPanel.jTextPane.getText();
			text="\r\n"+ "----德塔VPCS数据库服务器启动一切正常-总耗时:" 
					+ timeProcess.duration()+ "毫秒"+ text;
			text="\r\n"+ "..."+ text;
			app.appConfig.SectionJPanel.jTextPane.setText(text);
		}
		System.out.println("----德塔VPCS数据库服务器启动一切正常-总耗时:" 
		+ timeProcess.duration()+ "毫秒");
		app.ready= true;
		while(true){
			if(sleeperHall.getThreadsCount()< StableData.SLEEPERS_RANGE){
				Sleeper sleeper= new Sleeper(app);
				try {
					sleeper.hugPillow(sleeperHall, server.accept()
							, sleeper.hashCode());
					sleeper.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				haoHiYooFaker(sleeperHall);
			}
		}
	}
}