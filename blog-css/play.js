/*
Async JS: The word asynchronous means not occurring at the same time
We use promises to achieve async javascript: 
You use promises every time you use the fetch() method to get some data from a store.
*/

/*
CallBack: Calling one function in another function
*/

const one=()=>{
    two();
    console.log(`Step 1 Completed`);
   
}

const two=()=>{
    console.log(`Step 2`);
}
const arrow=(base, exponent)=>{
   if(exponent<0){
   return -1;
   }

   if(exponent==0 || exponent==1){
       return base;
   }
   
   return base * arrow(base, exponent - 1);

}


// stocks
let stocks={
    Fruits: ["strawberry", "grapes", "banana", "apple"],
    Liquid: ["water", "ice"],
    Holder: ["cone", "cup", "stick"],
    Toppings: ["chocolate", "peanuts"],
};

;
let order=(Fruit_name, call_production)=>{
    setTimeout(()=>{
        console.log(`${stocks.Fruits[Fruit_name]} was selected`);
        call_production()
    },2000);
}

let production=()=>{
    setTimeout(()=>{
        console.log(`production has been started`);

        setTimeout(()=>{
            console.log('The fruit has been chopped.');

            setTimeout(()=>{
                console.log(`${stocks.Liquid[0]} and ${stocks.Liquid[1]} was added`);
             
                setTimeout(()=>{
                   console.log('the machine was started');

                   setTimeout(()=>{
                      console.log(` ice cream was placed on the ${stocks.Holder[0]}`);

                      setTimeout(()=>{
                          console.log(`${stocks.Toppings[0]} was added as toppings`)

                          setTimeout(()=>{
                              console.log(`serve ice cream`);
                          }, 2000)
                        }, 3000)
                    }, 2000);
                }, 1000);
            }, 1000);
        }, 2000);
    }, 4000);
};

order(1,production);
