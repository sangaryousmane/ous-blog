let stocks={
    Fruits:['strawberry', 'grapes', 'bananna', 'Apple'],
    liquid: ['water', 'ice'],
    holder: ['cone', 'cup', 'stick'],
    toppings: ['chocolate', 'peanuts']
};

let is_shop_open=true;

// const toppings_choice=()=>{

//     return new Promise((resolve, reject)=>{
//        setTimeout(()=>{
//            resolve((console.log(`Which toppings would you love?`))         )
//        }, 4000)
//     });
// }

// async function kitchen(){
//     console.log(" A ");
//     console.log(" B ");
//     console.log(" C ");

//     await toppings_choice()

//     console.log(" D ");
//     console.log(" E ");

// }
// kitchen()
// console.log(" doing the dishes ");
// console.log(" cleaning the tables ");
// console.log(" taking another orders ");

function time(ms){
    return new Promise((resolve, reject)=>{
        if(is_shop_open){
            setTimeout(resolve, ms)
        }else{
            reject(new Error(`shop is closed.`));
        }
    });
};

async function kitchen(){
    try{
        await time(2000);
        console.log(`${stocks.Fruits[0]}.`);

        await time(0000);
        console.log('production started.');

        await time(2000);
        console.log('the fruit has been cut');

        await time(3000);
        console.log(`Adding ${stocks.liquid[0]} and ${stocks.liquid[1]}`);

        await time(2000);
        console.log(`starting machine`);

        await time(2000);
        console.log(`select ${stocks.holder[0]} for the ice cream`);

        await time(3000);
        console.log(`adding ${stocks.toppings[1]}`);
    }
    catch(error){
        console.log(`Customer Left because ${error.message}`);
    }
    finally{
        console.log(`Executes regardless...`);
    }
}
kitchen();