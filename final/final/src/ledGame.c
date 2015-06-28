#include "xparameters.h"
#include "xgpio.h"
#include "xutil.h"
#include<stdio.h>

//====================================================




int main (void) {

	 XGpio led1,led2,led3,led4;
		XGpio buttons;
		int i;
		int psb_check;//button的返回值

	    xil_printf("-- Start of the Program --\r\n");

		XGpio_Initialize(&led1,XPAR_LED1_DEVICE_ID);
		XGpio_SetDataDirection(&led1,1,0x00000000);//0是输出
		XGpio_Initialize(&led2,XPAR_LED2_DEVICE_ID);
		XGpio_SetDataDirection(&led2,1,0x00000000);//0是输出
		XGpio_Initialize(&led3,XPAR_LED3_DEVICE_ID);
		XGpio_SetDataDirection(&led3,1,0x00000000);//0是输出
		XGpio_Initialize(&led4,XPAR_LED4_DEVICE_ID);
		XGpio_SetDataDirection(&led4,1,0x00000000);//0是输出

		XGpio_Initialize(&buttons, XPAR_BTNS_4BIT_DEVICE_ID);
		XGpio_SetDataDirection(&buttons, 1, 0xffffffff);//1是输入




		//测试
		//int myrand[5]={0,1,2,3,4};
		int rValue;
		int success = 0;
		success=1;
		while(success != 0)//按对了才继续
		{
			//rValue = myrand[rand()%5];//产生1到4
			for (i=0; i<49999999; i++);
			rValue=rand()%4;
			if(rValue == 0)
			{
				//灯亮
				xil_printf("rValue %d\r\n",rValue);
				XGpio_DiscreteWrite(&led1,1,0xffffffff);
				XGpio_DiscreteWrite(&led2,1,0x00000000);
				XGpio_DiscreteWrite(&led3,1,0x00000000);
				XGpio_DiscreteWrite(&led4,1,0x00000000);

				//开始按按钮
				psb_check = XGpio_DiscreteRead(&buttons,1);
				while(psb_check==0)
					psb_check=XGpio_DiscreteRead(&buttons,1);
				if(psb_check==1)
				{

					success=1;
					XGpio_DiscreteWrite(&led1,1,0x00000000);
					XGpio_DiscreteWrite(&led2,1,0x00000000);
					XGpio_DiscreteWrite(&led3,1,0x00000000);
					XGpio_DiscreteWrite(&led4,1,0x00000000);
				}
				else
				{

					success=0;
					XGpio_DiscreteWrite(&led1,1,0xffffffff);
					XGpio_DiscreteWrite(&led2,1,0xffffffff);
					XGpio_DiscreteWrite(&led3,1,0xffffffff);
					XGpio_DiscreteWrite(&led4,1,0xffffffff);
				}
			}
			else if(rValue == 1)
			{
				//灯亮

				XGpio_DiscreteWrite(&led1,1,0x00000000);
				XGpio_DiscreteWrite(&led2,1,0xffffffff);
				XGpio_DiscreteWrite(&led3,1,0x00000000);
				XGpio_DiscreteWrite(&led4,1,0x00000000);

				//开始按按钮
				psb_check = XGpio_DiscreteRead(&buttons,1);
				while(psb_check==0)
					psb_check=XGpio_DiscreteRead(&buttons,1);
				if(psb_check==2)
				{

					success=1;
					XGpio_DiscreteWrite(&led1,1,0x00000000);
					XGpio_DiscreteWrite(&led2,1,0x00000000);
					XGpio_DiscreteWrite(&led3,1,0x00000000);
					XGpio_DiscreteWrite(&led4,1,0x00000000);
				}
				else
				{

					success=0;
					XGpio_DiscreteWrite(&led1,1,0xffffffff);
					XGpio_DiscreteWrite(&led2,1,0xffffffff);
					XGpio_DiscreteWrite(&led3,1,0xffffffff);
					XGpio_DiscreteWrite(&led4,1,0xffffffff);
				}
			}
			else if(rValue == 2)
			{
				//灯亮
				xil_printf("rValue %d\r\n",rValue);
				XGpio_DiscreteWrite(&led1,1,0x00000000);
				XGpio_DiscreteWrite(&led2,1,0x00000000);
				XGpio_DiscreteWrite(&led3,1,0xffffffff);
				XGpio_DiscreteWrite(&led4,1,0x00000000);

				//开始按按钮
				psb_check = XGpio_DiscreteRead(&buttons,1);
				while(psb_check==0)
					psb_check=XGpio_DiscreteRead(&buttons,1);
				if(psb_check==4)
				{

					success=1;
					XGpio_DiscreteWrite(&led1,1,0x00000000);
					XGpio_DiscreteWrite(&led2,1,0x00000000);
					XGpio_DiscreteWrite(&led3,1,0x00000000);
					XGpio_DiscreteWrite(&led4,1,0x00000000);
				}
				else
				{

					success=0;
					XGpio_DiscreteWrite(&led1,1,0xffffffff);
					XGpio_DiscreteWrite(&led2,1,0xffffffff);
					XGpio_DiscreteWrite(&led3,1,0xffffffff);
					XGpio_DiscreteWrite(&led4,1,0xffffffff);
				}
			}
			else if(rValue == 3)
			{
				//灯亮
				xil_printf("rValue %x\r\n",rValue);
				XGpio_DiscreteWrite(&led1,1,0x00000000);
				XGpio_DiscreteWrite(&led2,1,0x00000000);
				XGpio_DiscreteWrite(&led3,1,0x00000000);
				XGpio_DiscreteWrite(&led4,1,0xffffffff);

				//开始按按钮
				psb_check = XGpio_DiscreteRead(&buttons,1);
				while(psb_check==0)
					psb_check = XGpio_DiscreteRead(&buttons,1);
				if(psb_check==8)
				{

					success=1;
					XGpio_DiscreteWrite(&led1,1,0x00000000);
					XGpio_DiscreteWrite(&led2,1,0x00000000);
					XGpio_DiscreteWrite(&led3,1,0x00000000);
					XGpio_DiscreteWrite(&led4,1,0x00000000);
				}
				else
				{

					success=0;
					XGpio_DiscreteWrite(&led1,1,0xffffffff);
					XGpio_DiscreteWrite(&led2,1,0xffffffff);
					XGpio_DiscreteWrite(&led3,1,0xffffffff);
					XGpio_DiscreteWrite(&led4,1,0xffffffff);
				}
			}

		}

    return 0;
}
