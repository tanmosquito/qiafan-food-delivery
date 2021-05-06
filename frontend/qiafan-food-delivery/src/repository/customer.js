import AxiosProxy from './axios-proxy';
import {Message} from 'element-ui';

const requestURL = {
	authen: {
		signin: '/customer/authen/signin',
		signup: '/customer/authen/signup',
		logout: '/customer/authen/logout'
	}
}

const responseInfo = {
		authen: {
					200: ()=>({mesaage: '登陆成功', type:'sucess'}),
					404: ()=>({message: '账号或密码错误', type: 'error'}),
					401: ()=>({message: '账号或密码错误', type: 'error'})
				}
		};

export default {
	authen: {
		signin(data) {
			AxiosProxy.post(requestURL.authen['signin'], 
				JSON.stringify(data))
			.then(function(response) {
				Message(responseInfo['authen'][response.status]());
			})
			.catch(function(error) {
				if(error.status in responseInfo.authen) {
					Message(responseInfo.authen[error.status]());
				} else {
					Message({
						message: error.data['errorMessage'], 
						type: 'error'
					});
				}
			});
		},
		signup() {},
		logout() {
			AxiosProxy.post(requestURL.authen['logout']);
		}
	},
	address: {
		getAddressById() {

		}
	}
};