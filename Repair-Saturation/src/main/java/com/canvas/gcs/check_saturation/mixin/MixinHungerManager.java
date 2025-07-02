package com.canvas.gcs.check_saturation.mixin;

import com.canvas.gcs.check_saturation.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(HungerManager.class)
public abstract class MixinHungerManager {
	@Shadow
    private float saturationLevel;
	@Shadow
    private float exhaustion;

    @Inject(method = "add(IF)V", at = @At("RETURN"))
    public void add(int food, float saturationModifier, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }
    @Inject(method = "eat(Lnet/minecraft/item/Item;Lnet/minecraft/item/ItemStack;)V", at = @At("RETURN"))
    public void eat$Inject(Item item, ItemStack stack, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }
    @Inject(method = "update(Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At("RETURN"))
    public void update$Inject(PlayerEntity player, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    } 
    
	@Inject(method = "readNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("RETURN"))
	public void readNbt$Inject(NbtCompound nbt,  CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }

	@Inject(method = "writeNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("HEAD"))
    public void writeNbt$Inject(NbtCompound nbt, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }

	@Inject(method = "addExhaustion(F)V", at = @At("RETURN"))
    public void addExhaustion$Inject(float exhaustion, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }

	@Inject(method = "setSaturationLevel(F)V", at = @At("RETURN"))
    public void setSaturationLevel$Inject(float saturationLevel, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }

	@Inject(method = "setExhaustion(F)V", at = @At("RETURN"))
    public void setExhaustion$Inject(float exhaustion, CallbackInfo callback) {
		if(Float.isInfinite(this.saturationLevel) || Float.isNaN(this.saturationLevel)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect saturation detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect saturation detected\n" + stackTrace);
	        this.saturationLevel = 4.f;
		}
		if(Float.isInfinite(this.exhaustion) || Float.isNaN(this.exhaustion)) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			(new Exception()).printStackTrace(pw);
			String stackTrace = sw.toString(); // stack trace as a string
	    	RepairSaturation.LOGGER.info("incorrect exhaustion detected\n" + stackTrace);
	    	RepairSaturation.LOGGER.error("incorrect exhaustion detected\n" + stackTrace);
	        this.exhaustion = 4.f;
		}
    }
}
