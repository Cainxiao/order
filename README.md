api:

创建订单
POST /order/create

参数
name: "张三"
phone: "18868822111"
address: "慕课网"
openid: "123"
items: [{
    productId: "23333",
    productQuantity: 2 //购买数量
}]

返回
{
    "code": 0,
    "msg": "成功",
    "data": {
        "orderId": "12332132323434"
    }

}