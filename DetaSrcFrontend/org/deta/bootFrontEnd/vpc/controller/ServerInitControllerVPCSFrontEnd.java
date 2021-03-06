package org.deta.bootFrontEnd.vpc.controller;
import java.io.IOException;

import java.net.ServerSocket;
import java.util.Properties;
import org.deta.bootFrontEnd.vpc.process.TimeProcess;
import org.deta.bootFrontEnd.vpc.sleeper.Sleeper;
import org.deta.bootFrontEnd.vpc.sleeper.SleeperHall;
import org.lygFrontend.common.utils.DetaUtil;
public class ServerInitControllerVPCSFrontEnd {
	private ServerSocket server;
	@SuppressWarnings("unused")
	private Properties properties;
	private int port;
	{
		properties= new Properties();
		//try {
			//properties.load(new FileInputStream(new File("src/main/resourcesFrontEnd/property.proterties")));
			System.out.println("----德塔VPCS前端服务器资源载入:成功！");
		//}catch (IOException e) {
		//	e.printStackTrace();
		//}
	}

	public void init() throws IOException {
		try {
			port= 80;
			server= new ServerSocket(port);
			System.out.println("----德塔VPCS前端服务器端口启动:" + port);
			DetaUtil.initDB();
			System.out.println("----德塔VPCS前端服务器DMA确认:成功！");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void haoHiYooFaker(SleeperHall sleeperHall) {
		sleeperHall.callSkivvy(); 
	}

	public void initServer() throws IOException {
		System.out.println("----DETA VPCS--1.7");
		System.out.println("----Author: 罗瑶光");
		System.out.println("----浏阳德塔软件开发有限公司开源项目");
		TimeProcess timeProcess= new TimeProcess();
		timeProcess.begin();
		SleeperHall sleeperHall= new SleeperHall();
		init();
		timeProcess.end();
		System.out.println("----德塔VPCS前端服务器启动一切正常-总耗时:"+ timeProcess.duration()+ "毫秒");
		while(true){	
			if(sleeperHall.getThreadsCount()< 500){
				Sleeper sleeper= new Sleeper();
				sleeper.hugPillow(sleeperHall, server.accept(), sleeper.hashCode());
				sleeper.start();
			}else {
				haoHiYooFaker(sleeperHall);
			}
		}
	}
}