package com.jfx;

import com.jfx.ErrUnknownSymbol;
import com.jfx.MarketInfo;
import com.jfx.strategy.StrategyRunner;

import java.io.IOException;
import java.util.Date;

public class MyStrategy extends com.jfx.strategy.Strategy{
    public void init(String symbol, int period, StrategyRunner strategyRunner) {
        try {
            System.out.println("init method");
            super.init(symbol, period, strategyRunner);
        } catch (ErrUnknownSymbol e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        //
        // load existing orders, recover itself from the previous shutdown
        //
    }
    public void deinit() {
        // release resources on EA exit
        System.out.println("deinit method");
    }
    public void coordinate() {
    	
        // trading logic goes here
		/* make use of all API methods: accountBalance, accountCompany, accountCredit, accountCurrency, accountEquity,
		accountFreeMargin, accountMargin, accountName, accountNumber, accountProfit, comment, day, dayOfWeek, dayOfYear,
		getLastError, getTickCount, hour, iAC, iAD, iADX, iAlligator, iAO, iATR, iBands, iBars, iBarShift, iBearsPower, iBullsPower,
		iBWMFI, iCCI, iClose, iCustom, iDeMarker, iEnvelopes, iForce, iFractals, iGator, iHigh, iHighest, iLow, iLowest, iMA, iMACD,
		iMFI, iMomentum, iOBV, iOpen, iOsMA, iRSI, iRVI, iSAR, isConnected, isDemo, iStdDev, isTesting, iStochastic,
		isTradeContextBusy, isVisualMode, iTime, iVolume, iWPR, marketInfo, minute, month, objectCreate, objectCreate, objectCreate,
		objectDelete, objectGet, objectGetFiboDescription, objectSet, objectSetFiboDescription, objectSetText, objectsTotal, objectType,
		orderClose, orderCloseBy, orderClosePrice, orderCloseTime, orderComment, orderCommission, orderDelete, orderExpiration,
		orderLots, orderMagicNumber, orderModify, orderOpenPrice, orderOpenTime, orderPrint, orderProfit, orderSelect, orderSend,ordersHistoryTotal, orderStopLoss, ordersTotal, orderSwap, orderSymbol, orderTakeProfit, orderTicket, orderType, print,
		refreshRates, seconds, timeCurrent, year
		*/
    	try{
            System.out.println("Time " + timeCurrent() + " " + iTime(getSymbol(), getTimeframe(), 0));
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }
}