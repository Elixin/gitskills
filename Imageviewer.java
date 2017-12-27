import java.awt.*;
import java.io.*;
import javax.swing.*;



public class Imageviewer 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(()->{
			JFrame frame = new ImageViewerFrame();//定义一个frame窗口对象来调用ImageViewerFrame()
			frame.setTitle("  图片查看器");		//设置标题
			frame.setLocation(600,40);		//设置边距左边距为600 ，上边距为40
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //单击窗口关闭按钮执行关闭
			frame.setVisible(true);			//设置窗口可见，必有语句之一，否则窗口无意义
		});
	}
}

class ImageViewerFrame extends JFrame
{
	
	private static final long serialVersionUID = 1L;		//静态长整型变量
	private JLabel label;				// private 设置这个类中私有对象
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 800; //定义的几个常量
	private static final int DEFAULT_HEIGHT = 1000;//同上
	
	public ImageViewerFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);		//设置窗口大小
		label = new JLabel();
		add(label);
		/*---------------------分段线----------------------------*/
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		/*---------------------分段线----------------------------*/
		JMenu menu = new JMenu("文件");
		menuBar.add(menu);
		/*---------------------分段线----------------------------*/
		JMenuItem openItem = new JMenuItem("打开文件");
		menu.add(openItem);
		openItem.addActionListener(event ->{
			int result = chooser.showOpenDialog(null);
			
			if(result ==JFileChooser.APPROVE_OPTION) 
			{
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		});
		/*---------------------分段线----------------------------*/
		JMenuItem exitItem = new JMenuItem("退出");
		menu.add(exitItem);
		exitItem.addActionListener(event -> System.exit(0));
		
	}
}
