//
//  NetworkService.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/31/23.
//

import Foundation

enum NetworkError: Error {
    case error(statusCode: Int, data: Data?)
    case notConnected
    case cancelled
    case generic(Error)
    case urlGeneration
}

protocol NetworkCancellable {
    func cancel()
}

protocol NetworkService {
    typealias CompletionHandler = (Result<Data?, NetworkError>) -> Void
    
    func request(endpoint: Requestable, completion: @escaping CompletionHandler) -> NetworkCancellable?
}

final class DefaultNetworkService {
    
    private let config: NetworkConfigurable
    
    init(
        config: NetworkConfigurable
    ) {
        self.config = config
    }
}

extension DefaultNetworkService: NetworkService {
    
    func request(endpoint: Requestable, completion: @escaping CompletionHandler) -> NetworkCancellable? {
        
        return nil
    }

}
