import axios from 'axios';
import Vue from 'vue';
import {MessageBox} from 'element-ui';

Vue.component(MessageBox.name, MessageBox);

let axiosInstance = axios.create({
	baseURL: '/api',
	timeout: 1000,
	validateStatus(status) {
		return status < 500;
	}
});

axiosInstance.interceptors.response.use(function(error) {
	if(error.status >= 500) {
		MessageBox.alert('服务器异常。', '请求出错');
	} else {
		return Promise.reject(error);
	}
});

export default {
	get(url, data) {
		return axiosInstance.get(url, data)
	},
	post(url, data) {
		return axiosInstance.post(url, data);
	}
};