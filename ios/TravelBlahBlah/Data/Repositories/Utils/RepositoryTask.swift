//
//  RepositoryTask.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 1/4/24.
//

import Foundation

class RepositoryTask: Cancellable {
    var networkTask: NetworkCancellable?
    var isCancelled: Bool = false
    
    func cancel() {
        networkTask?.cancel()
        isCancelled = true
    }
}
