package com.canvas.gcs.check_saturation.mixin;

import com.canvas.gcs.check_saturation.*;
import com.canvas.gcs.check_saturation.RepairSaturation;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


@Mixin(ServerPlayerEntity.class)
public abstract class MixinServerPlayerEntity extends PlayerEntity{
	 private DefaultedList<ItemStack> mainCopy = null;
	 private MixinServerPlayerEntity(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }
	@Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        // if main copy is null, set it to player inventory and check each stack
        if(mainCopy == null) {
            mainCopy = copyDefaultedList(this.getInventory().main);
            runCheck();
        }

        // if main copy =/= inventory, run check and set mainCopy to inventory
        if (!(this).getInventory().main.equals(mainCopy)) {
            mainCopy = copyDefaultedList((this).getInventory().main);
            runCheck();
        }
    }

    @Unique
    private DefaultedList<ItemStack> copyDefaultedList(DefaultedList<ItemStack> list) {
        DefaultedList<ItemStack> newList = DefaultedList.ofSize(36, ItemStack.EMPTY);

        for (int i = 0; i < list.size(); i++) {
            newList.set(i, list.get(i));
        }

        return newList;
    }

    @Unique
    private void runCheck() {
        (this).getInventory().main.forEach(itemStack -> {
        	checkItem(itemStack);
        });
    }
    private static Enchantment getRandomElement(Set<Enchantment> set)
	{
	
	    Random random = new Random();
	
	    // Generate a random number using nextInt
	    // method of the Random class.
	    int randomNumber = random.nextInt(set.size());
	
	    Iterator<Enchantment> iterator = set.iterator();
	
	    int currentIndex = 0;
	    Enchantment randomElement = null;
	
	    // iterate the HashSet
	    while (iterator.hasNext()) {
	
	        randomElement = iterator.next();
	
	        // if current index is equal to random number
	        if (currentIndex == randomNumber)
	            return randomElement;
	
	        // increase the current index
	        currentIndex++;
	    }
	
	    return randomElement;
	}
    private void checkItem(ItemStack stack) {
    	Set<Enchantment> toRemove = new HashSet();
    	Set<Enchantment> toCheck = new HashSet();
        Map<Enchantment, Integer> enchantmentMap = EnchantmentHelper.get(stack);

        // Loop through the enchantment count until the random number is hit, then set the enchantment
        for (Map.Entry<Enchantment, Integer> entry : enchantmentMap.entrySet()) {
        	Enchantment ench = entry.getKey();
        	for(Enchantment prevEnch: toCheck) {
        		if(!prevEnch.canCombine(ench)) {
        			toRemove.add(ench);
        			toRemove.add(prevEnch);
        		}
        	}
    		toCheck.add(ench);
        }
        if(toRemove.size() > 1) {
	        do {
		    	Enchantment remove = getRandomElement(toRemove);
		    	toRemove.remove(remove);
	        	enchantmentMap.remove(remove);
	        } while(toRemove.size() > 1);
	        EnchantmentHelper.set(enchantmentMap, stack);
        }
    }
}
