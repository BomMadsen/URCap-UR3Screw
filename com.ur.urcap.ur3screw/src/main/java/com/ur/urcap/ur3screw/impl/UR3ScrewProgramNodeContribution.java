package com.ur.urcap.ur3screw.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.robot.RobotModel.RobotType;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.ui.annotation.Input;
import com.ur.urcap.api.ui.component.InputEvent;
import com.ur.urcap.api.ui.component.InputCheckBox;
import com.ur.urcap.api.ui.component.InputTextField;
import com.ur.urcap.api.ui.component.InputRadioButton;

public class UR3ScrewProgramNodeContribution implements ProgramNodeContribution {
	
	private final DataModel model;
	private final URCapAPI api;
	
	public UR3ScrewProgramNodeContribution(URCapAPI api, DataModel model) {
		this.api = api;
		this.model = model;
	}
	
	/*
	 * Functionality code starts here
	 */
	
	private static final String DIRECTION = "direction";
	private static final String ROTATIONS = "rotations";
	private static final String ROTATIONScb = "rotationsCB";
	private static final String TORQUE = "torque";
	private static final String TORQUEcb = "torqueCB";
	private static final String DISTANCE = "distance";
	private static final String DISTANCEcb = "distanceCB";
	private static final String TIME = "time";
	private static final String TIMEcb = "timeCB";
	private static final String FORCE = "force";
	private static final String SPEED = "speed";
	
	
	// Inputs from ProgramNode screen
	@Input(id = "directionCW")
	private InputRadioButton directionRadioCW;
	
	@Input(id = "directionCCW")
	private InputRadioButton directionRadioCCW;
	
	// Rotations
	@Input(id = "cbRotations")
	private InputCheckBox rotationsCB;
	
	@Input(id = "rotations")
	private InputTextField rotationsStr;
	
	// Torque
	@Input(id = "cbTorque")
	private InputCheckBox torqueCB;
	
	@Input(id = "torque")
	private InputTextField torqueStr;
	
	// Distance
	@Input(id = "cbDistance")
	private InputCheckBox distanceCB;
	
	@Input(id = "distance")
	private InputTextField distanceStr;
	
	// Time
	@Input(id = "cbTime")
	private InputCheckBox timeCB;
	
	@Input(id = "time")
	private InputTextField timeStr;
	
	// General
	@Input(id = "force")
	private InputTextField forceStr;
	
	@Input(id = "speed")
	private InputTextField speedStr;
	
	// Input translation functions
	
	// Direction
	private Integer getDirection(){
		return model.get(DIRECTION, 1);
	}
	
	private void setDirection(Integer dir){
		model.set(DIRECTION, dir);
	}
	
	@Input(id = "directionCW")
	public void onDirectionChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			if(directionRadioCW.isSelected()){
				setDirection(1);
			}
			else{
				setDirection(-1);
			}
		}
	}
	
	// Rotations
	private String getRotations(){
		return model.get(ROTATIONS, "0");
	}
	
	private boolean getRotationsCB(){
		return model.get(ROTATIONScb, false);
	}
	
	private void setRotations(String rot){
		model.set(ROTATIONS, rot);
	}
	
	private void setRotationsCB(boolean cb){
		model.set(ROTATIONScb, cb);
	}
	
	@Input(id = "cbRotations")
	public void onRotationsCBChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setRotationsCB(rotationsCB.isSelected());
			rotationsStr.setEnabled(getRotationsCB());
		}
	}
	
	@Input(id = "rotations")
	public void onRotationsChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setRotations(rotationsStr.getText());
		}
	}
	
	// Torque
	private String getTorque(){
		return model.get(TORQUE, "0");
	}
	
	private boolean getTorqueCB(){
		return model.get(TORQUEcb, false);
	}
	
	private void setTorque(String tor){
		model.set(TORQUE, tor);
	}
	
	private void setTorqueCB(boolean cb){
		model.set(TORQUEcb, cb);
	}
	
	@Input(id = "cbTorque")
	public void onTorqueCBChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setTorqueCB(torqueCB.isSelected());
			torqueStr.setEnabled(getTorqueCB());
		}
	}
	
	@Input(id = "torque")
	public void onTorqueChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setTorque(torqueStr.getText());
		}
	}
	
	// Distance
	private String getDistance(){
		return model.get(DISTANCE, "0");
	}
	
	private boolean getDistanceCB(){
		return model.get(DISTANCEcb, false);
	}
	
	private void setDistance(String dist){
		model.set(DISTANCE, dist);
	}
	
	private void setDistanceCB(boolean cb){
		model.set(DISTANCEcb, cb);
	}
	
	@Input(id = "cbDistance")
	public void onDistanceCBChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setDistanceCB(distanceCB.isSelected());
			distanceStr.setEnabled(getDistanceCB());
		}
	}
		
	@Input(id = "distance")
	public void onDistanceChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setDistance(distanceStr.getText());
		}
	}
	
	// Time
	private String getTime(){
		return model.get(TIME, "0");
	}
	
	private boolean getTimeCB(){
		return model.get(TIMEcb, false);
	}
	
	private void setTime(String t){
		model.set(TIME, t);
	}
	
	private void setTimeCB(boolean cb){
		model.set(TIMEcb, cb);
	}
		
	@Input(id = "cbTime")
	public void onTimeCBChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setTimeCB(timeCB.isSelected());
			timeStr.setEnabled(getTimeCB());
		}
	}
		
	@Input(id = "time")
	public void onTimeChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setTime(timeStr.getText());
		}
	}
	
	// Force
	private String getForce(){
		return model.get(FORCE, "15");
	}
	
	private void setForce(String force){
		model.set(FORCE,force);
	}
	
	@Input(id = "force")
	public void onForceChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setForce(forceStr.getText());
		}
	}
	
	// Speed
	private String getSpeed(){
		return model.get(SPEED, "360");
	}
	
	private void setSpeed(String speed){
		model.set(SPEED, speed);
	}
	
	@Input(id = "speed")
	public void onSpeedChange(InputEvent event){
		if (event.getEventType() == InputEvent.EventType.ON_CHANGE){
			setSpeed(speedStr.getText());
		}
	}
	
	/* 
	 * Functionality code ends. Required functions below.
	 */
	
	@Override
	public void openView() {
		System.out.println("From DataModel:");
		System.out.println("Direction: "+getDirection());
		System.out.println("Rotations: "+getRotations());
		System.out.println("Torque: "+getTorque());
		System.out.println("Distance: "+getDistance());
		System.out.println("Time: "+getTime());
		
		if(getDirection()==1){
			directionRadioCW.setSelected();
		}
		else{
			directionRadioCCW.setSelected();
		}
		
		if(getRotationsCB()){
			rotationsCB.setSelected(true);
			rotationsStr.setEnabled(true);
			rotationsStr.setText(getRotations());
		}
		else{
			rotationsCB.setSelected(false);
			rotationsStr.setEnabled(false);
			rotationsStr.setText("0");
		}
		
		if(getTorqueCB()){
			torqueCB.setSelected(true);
			torqueStr.setEnabled(true);
			torqueStr.setText(getTorque());
		}
		else{
			torqueCB.setSelected(false);
			torqueStr.setEnabled(false);
			torqueStr.setText("0");
		}
		
		if(getDistanceCB()){
			distanceCB.setSelected(true);
			distanceStr.setEnabled(true);
			distanceStr.setText(getDistance());
		}
		else{
			distanceCB.setSelected(false);
			distanceStr.setEnabled(false);
			distanceStr.setText("0");
		}
		
		if(getTimeCB()){
			timeCB.setSelected(true);
			timeStr.setEnabled(true);
			timeStr.setText(getTime());
		}
		else{
			timeCB.setSelected(false);
			timeStr.setEnabled(false);
			timeStr.setText("0");
		}
		
		forceStr.setText(getForce());
		speedStr.setText(getSpeed());
		
		// Add check for whether this is a UR3 here.
		RobotType rm = api.getRobotModel().getRobotType();
		if ( rm == RobotType.UR3 ){
			// Robot type is correct
			;
		}
	}
	
	
	@Override
	public void closeView() {
		;
	}
	
	@Override
	public boolean isDefined() {
		Boolean rot_def = getRotationsCB() && !getRotations().equals(null);
		Boolean tor_def = getTorqueCB() && !getTorque().equals(null);
		Boolean dist_def = getDistanceCB() && !getDistance().equals(null);
		Boolean time_def = getTimeCB() && !getTime().equals(null);
		return (rot_def || tor_def || dist_def || time_def);
	}
	
	@Override
	public String getTitle() {
		String title = "UR3 Screw";
		if(isDefined()){
			if(getDirection()==1){
				title += ": CW";
			}
			else{
				title += ": CCW";
			}
			
			if(getRotationsCB()){
				title += ",R"+getRotations();
			}
			
			if(getTorqueCB()){
				title += ",T"+getTorque();
			}
			
			if(getDistanceCB()){
				title += ",D"+getDistance();
			}
			
			if(getTimeCB()){
				title += ",t"+getTime();
			}
			
			return title;
		}
		else{
			return title;
		}
		
	}
	
	
	@Override
	public void generateScript(ScriptWriter writer) {
		writer.appendLine("# UR3 Screwing code starts here");
		
		// Global return state variables
		writer.globalVariable("UR3_Screw_exit_reason", "\"\"");
		
		// Measurement of start pose
		writer.assign("rotate_vector", "get_actual_joint_positions()");
		writer.assign("rotate_W3", "rotate_vector[5]");
		writer.assign("start_point", "get_actual_tcp_pose()");
				
		/*
		 * Initialization of variables
		 */
		if(getRotationsCB()){
			// Rotations
			writer.assign("rotate_sum", "0");
		}
		
		if(getTimeCB()){
			// Time
			writer.assign("time_last", "0");
			writer.assign("final_timer", "0");
			writer.defineThread("ScrewTimer");
				writer.whileTrue();
					writer.sleep(0.1);
					writer.assign("final_timer", "final_timer+0.1");
				writer.end();
			writer.end();
		}
		if(getTorqueCB()){
			// Speed/torque
			writer.assign("speed_list", "[0,0,0,0]");
			writer.assign("speed_counter", "0");
			writer.assign("speed_sum", "0");
			writer.assign("speed_reached", "0");
		}
		
		/* 
		 * Starting force mode loop
		 */
		writer.appendLine("force_mode(tool_pose(),[0,0,1,0,0,1],[0,0,"+getForce()+",0,0,("+getTorque()+"*"+getDirection()+")],2,[0.1,0.1,0.15,0.35,0.35,d2r("+getSpeed()+")])");
			writer.assign("ur3screwstop", "False");
			if(getTimeCB()){
				writer.runThread("ScrewTimerFlag", "ScrewTimer()");
			}
			writer.sync();
			writer.whileNot("ur3screwstop");
				if(getRotationsCB()){
					// Rotations
					writer.assign("curr_vector", "get_actual_joint_positions()");
					writer.assign("curr_rot", "curr_vector[5]");
					writer.assign("rotate_sum", "r2d(curr_rot-rotate_W3)");
					writer.assign("final_rotations", "norm(rotate_sum/360)");
				}
				
				if(getTorqueCB()){
					// Speed/torque
					writer.assign("speedmeasure", "get_actual_joint_speeds()");
					writer.assign("speed_list[speed_counter]", "r2d(norm(speedmeasure[5]))");
					writer.ifCondition("speed_counter == 3");
						writer.assign("speed_sum", "speed_sum+speed_list[speed_counter]-speed_list[0]");
					writer.elseCondition();
						writer.assign("speed_sum", "speed_sum+speed_list[speed_counter]-speed_list[(speed_counter+1)]");
					writer.end();
					writer.assign("Speed_W3", "speed_sum/4.0");
					writer.ifCondition("Speed_W3 > ("+getSpeed()+"* 0.75)");
						writer.assign("speed_reached", "1");
					writer.end();
					writer.assign("speed_counter", "speed_counter+1");
					writer.ifCondition("speed_counter>3");
						writer.assign("speed_counter", "0");
					writer.end();
				}
				
				if(getDistanceCB()){
					// Distance
					writer.assign("dist_vector", "pose_sub(start_point,get_actual_tcp_pose())");
					writer.assign("final_distance", "norm(dist_vector[2])");
				}
				
				// Check when we are done
				if(getRotationsCB()){
					writer.ifCondition("final_rotations >="+getRotations());
						writer.assign("UR3_Screw_exit_reason", "\"Rotations\"");
						writer.assign("ur3screwstop", "True");
					writer.end();
				}
				
				if(getTimeCB()){
					writer.ifCondition("final_timer >="+getTime());
						writer.assign("UR3_Screw_exit_reason", "\"Time\"");
						writer.assign("ur3screwstop", "True");
					writer.end();
				}
				
				if(getDistanceCB()){
					writer.ifCondition("final_distance >=("+getDistance()+"/1000)");
						writer.assign("UR3_Screw_exit_reason", "\"Distance\"");
						writer.assign("ur3screwstop", "True");
					writer.end();
				}
				
				if(getTorqueCB()){
					writer.ifCondition("(speed_reached==1) and (Speed_W3<("+getSpeed()+"/2))");
						writer.assign("UR3_Screw_exit_reason", "\"Torque\"");
						writer.assign("ur3screwstop", "True");
					writer.end();
				}
				
				writer.sync();
			writer.end();
		writer.appendLine("end_force_mode()");
		if(getTimeCB()){
			writer.appendLine("kill ScrewTimerFlag");
		}
		// This is the place to add release screw bit code
		writer.appendLine("stopl(5)");
		writer.appendLine("reset_revolution_counter(qNear=[0,0,0,0,0,rotate_W3])");
				
				
		
		writer.appendLine("# UR3 Screwing code ends here");
	}


}