/*
A promise object has the following internal properties
state:
1. pending: when the execution function starts.
2. fulfilled: when the promise resolves successfully.
3. rejected: when the promise rejects or fails.

results:
1. undefined: initially, when the state value is pending.
2. value: when the promise is resolved(value).
3. error: when the promise is rejected.

A promise that is either resolved or rejected is called settled.
We get a .then() method from every promise. 
The sole purpose of this method is to let the consumer know about the outcome of a promise. 
It accepts two functions as arguments, result and error.
*/

// let promise=new Promise(function(resolve, reject){

//     setTimeout(function(){
//         reject(new Error("Jack fell down and broke his crown. And Jill came tumbling after"));
//     }, 2000);
// });


// const grandParentsCooking= ()=>{
//     promise.catch(function(error){
//         console.log(`OMG! ${error.message}`);
//     });
// };

// grandParentsCooking();

// let promise=new Promise(function(resolve, reject){
//     setTimeout(function(){
//         reject(new Error("Yaass!!! Mom, here's the money as promised."));
//     }, 3000);
// });


// const mommy=()=>{
//     promise.catch(function(result){
//         console.log(`${result.message}`);
//     });
// };

// mommy();


let stocks={
    Fruits:['strawberry', 'grapes', 'bananna', 'Apple'],
    liquid: ['water', 'ice'],
    holder: ['cone', 'cup', 'stick'],
    toppings: ['chocolate', 'peanuts']
};

let isShopOpen=true;

const order=(time, work)=>{

    return new Promise((resolve, reject)=>{
        if(isShopOpen){
            setTimeout(()=>{
                resolve(work())
            }, time)
        }
        else{
            reject(console.log('Sorry! our shop is closed.'));
        }
    });
};

order(2000, ()=> console.log(`${stocks.Fruits[0]} was selected.`))

.then(()=>{
    return order(0000, ()=>console.log(`Production has started`))
})
.then(()=>{
  return order(2000, ()=>console.log(`the fruit has been cut.`))
})
.then(()=>{
    return order(2000, ()=>console.log(`${stocks.liquid[0]} and ${stocks.liquid[1]} has been added.`))
})
.then(()=>{
   return order(3000, ()=>console.log(`the machine has been started.`))
})
.then(()=>{
    return order(2000, ()=>console.log(`ice was placed on ${stocks.holder[0]}.`))
})
.then(()=>{
    return order(2000, ()=>console.log(`${stocks.toppings[1]} is added.`))
})
.then(()=>{
    return order(2000, ()=>console.log(`ice cream 🍦🍦 is served.`))
})
.catch(()=>{
    let error=new Error('Customer left');
    console.log(`${error.message} 😭`);
})
.finally(()=>{
    console.log(`Day ended, Order and Production closed.🎉🎉🎉`);
});