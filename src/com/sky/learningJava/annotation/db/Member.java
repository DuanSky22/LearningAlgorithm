/**
* @author DuanSky
* @date 2015年9月7日 下午10:09:18
* @content 
*/
package com.sky.learningJava.annotation.db;

@DBTable(name="MEMBER")
public class Member {
	@SQLString(30) String firstName;
	@SQLString(50) String lastName;
	@SQLInteger Integer age;
	@SQLString(value=30,constraints=@Constraints(primaryKey=true)) String handle;
	static int memberCount;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Integer getAge() {
		return age;
	}
	public String getHandle() {
		return handle;
	}
	public static int getMemberCount() {
		return memberCount;
	}

	public String toString(){
		return handle;
	}
	
}
