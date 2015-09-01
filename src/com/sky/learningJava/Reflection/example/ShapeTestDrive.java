package com.sky.learningJava.Reflection.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/*
 *  @author: DuanSky
 *    @time: 2015骞�8鏈�19鏃� 涓婂崍11:16:16
 * @content:
		鍦ㄦ湰渚嬪瓙涓富瑕佺敤鏉ュ睍绀篔ava澶氭�佹�х殑涓�闈€��
		闈㈠悜瀵硅薄鐨勫熀鏈洰鐨勬槸锛氳浠ｇ爜鍙搷浣滃鍩虹被鐨勫紩鐢ㄣ�傜敤鍩虹被寮曠敤鎸囧悜
	瀛愮被瀵硅薄銆�
 */
public class ShapeTestDrive {
	public static void main(String args[]){
		//澹版槑浜嗕竴涓猯ist锛岄噷闈㈠瓨鍌ㄧ殑鏄埗绫籗hape绫诲瀷鐨勫紩鐢紝鎸囧悜瀛愮被鍚勭绫诲瀷鐨勫璞°��
		//閫氳繃鍔ㄦ�佸姞杞斤紝鑳藉鍑嗙‘璋冪敤瀛愮被鐨勬柟娉曘��
		//鍔ㄦ�佸姞杞芥槸浠庡瓙绫诲璞″弽鍚戝悜涓婃煡鎵撅紝鎵惧埌绗竴涓敞鍐岀殑鏂规硶锛屽氨杩愯瀹冦��
		List<Shape> shapeList= Arrays.asList(new Square(),new Circle(),new Triangle());
		for(Shape shape : shapeList){
			shape.draw();
		}
		//鍚戜笂杞瀷涓簊hape
		Shape shape=shapeList.get(0);
		//鍦ㄥ悜涓嬭浆鍨嬩负square
		Square square=(Square)shape;
		square.draw();
		//濡傛灉鍚戜笅杞瀷鎴怌ircle
		if(shape instanceof Circle){
			Circle circle=(Circle)shape;
			circle.draw();
		}
		Object[] array={new Circle(),new Square(),new Triangle()};
//		if(array instanceof Array.class){
//			System.out.println("array!");
//		}
		for(Object object : array){
			if(object instanceof Circle){
				((Circle) object).draw();
			}
			else if(object instanceof Square){
				((Square) object).draw();
			}
			else if(object instanceof Triangle){
				((Triangle) object).draw();
			}
		}
			
	}
}
