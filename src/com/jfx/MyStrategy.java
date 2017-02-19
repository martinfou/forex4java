package com.jfx;

import com.jfx.ErrUnknownSymbol;
import com.jfx.MarketInfo;
import com.jfx.strategy.StrategyRunner;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

public class MyStrategy extends com.jfx.strategy.Strategy{
	Logger logger = Logger.getLogger(MyStrategy.class);
	static Date lastBarTime; 
    public void init(String symbol, int period, StrategyRunner strategyRunner) {
        try {
            System.out.println("init method");
            logger.info("testing logger");
            lastBarTime = new Date();
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
    	
    	if(isNewBar())
    	{
    		//logger.info("Got a new bar");
    		try {
				long ticketNo = orderSend(
				        symbol,
				        TradeOperation.OP_BUY,
				        0.01,
				        marketInfo(symbol, MarketInfo.MODE_ASK),
				        10,
				        marketInfo(symbol, MarketInfo.MODE_ASK)-0.0005, 
				        marketInfo(symbol, MarketInfo.MODE_ASK)+0.0005, "comment", 0, null
				);
			} catch (ErrInvalidFunctionParamvalue | ErrCustomIndicatorError | ErrStringParameterExpected
					| ErrIntegerParameterExpected | ErrUnknownSymbol | ErrInvalidPriceParam | ErrTradeNotAllowed
					| ErrLongsNotAllowed | ErrShortsNotAllowed | ErrCommonError | ErrInvalidTradeParameters
					| ErrServerBusy | ErrOldVersion | ErrNoConnection | ErrTooFrequentRequests | ErrAccountDisabled
					| ErrInvalidAccount | ErrTradeTimeout | ErrInvalidPrice | ErrInvalidStops | ErrInvalidTradeVolume
					| ErrMarketClosed | ErrTradeDisabled | ErrNotEnoughMoney | ErrPriceChanged | ErrOffQuotes
					| ErrRequote | ErrOrderLocked | ErrLongPositionsOnlyAllowed | ErrTooManyRequests | ErrTradeTimeout2
					| ErrTradeTimeout3 | ErrTradeTimeout4 | ErrTradeModifyDenied | ErrTradeContextBusy
					| ErrTradeExpirationDenied | ErrTradeTooManyOrders e) {
				logger.error(e.getMessage());
			}	
    	}
    	
    	try{
 
    	}
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }
    
    private boolean isNewBar(){
    	try {
    		
			Date iTime = iTime(getSymbol(), getTimeframe(), 0);
			if(!lastBarTime.equals(iTime)){
				//System.out.println(lastBarTime.toString());
				lastBarTime=iTime;
				return true;
			}
		} catch (ErrHistoryWillUpdated e) {
			logger.info("testing logger");
			e.printStackTrace();
		} catch (ErrUnknownSymbol e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    	
    }
    
}